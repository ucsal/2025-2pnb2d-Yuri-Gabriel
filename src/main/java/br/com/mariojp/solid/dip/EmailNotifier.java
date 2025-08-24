package br.com.mariojp.solid.dip;

public class EmailNotifier {
	private MailSender smtp;

	public void welcome(User user) {
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			this.smtp = new TestSmtpClient();
		} else {
			this.smtp = new SmtpClient();
		}
		smtp.send(user.email(), "Bem-vindo", "Olá " + user.name());
	}
}
