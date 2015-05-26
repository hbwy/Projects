package cms.backend.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckcodeServlet extends HttpServlet {
	private int width;
	private int height;
	private int number;
	private String codes;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		// 创建图片
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		// 创建白色背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);

		Random random = new Random();
		// 设置字符间距
		int x = (width - 1) / number;
		int y = height - 4;
		// 随机生成字符
		// str用来装验证码
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < number; i++) {
			String code = String.valueOf(codes.charAt(random.nextInt(codes
					.length())));
			g.setColor(new Color(random.nextInt(255), random.nextInt(255),
					random.nextInt(255)));
			Font font = new Font("Arial", Font.PLAIN,random(height, height / 2));
			g.setFont(font);
			str.append(code);
			g.drawString(code, x * i + 1, y);
		}
		// 把验证码放在session里面
		request.getSession().setAttribute("codes", str.toString());

		// 随机产生点
		for (int i = 0; i < 20; i++) {
			int red = random.nextInt(255);
			int green = random.nextInt(255);
			int blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		OutputStream out = response.getOutputStream();
		// 将图片转换成JPEG格式
		ImageIO.write(image, "JPEG", out);
		// JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		// encoder.encode(image);
		out.flush();
		out.close();
		response.flushBuffer();
		// out = pageContext.pushBody();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		width = Integer.parseInt(config.getInitParameter("width"));
		height = Integer.parseInt(config.getInitParameter("height"));
		number = Integer.parseInt(config.getInitParameter("number"));
		codes = config.getInitParameter("codes");
		super.init(config);
	}

	// 取得自定义范围内的随机数
	private int random(int max, int min) {
		int m = new Random().nextInt(99999) % (max - min);
		return m + min;
	}
}