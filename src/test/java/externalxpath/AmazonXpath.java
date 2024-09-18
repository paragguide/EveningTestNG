package externalxpath;

public class AmazonXpath 
{
	// login xpath
	
	public static final String signin = "//*[text() = 'Hello, sign in']";
	public static final String uid = "//*[@id=\"ap_email\"]";
	public static final String ctnbtn = "//*[@id=\"continue\"]";
	public static final String err1 = "(//*[@class = 'a-alert-content'])[4]";
	public static final String pwd = "//*[@id=\"ap_password\"]";
	public static final String submit = "//*[@id=\"signInSubmit\"]";
	public static final String err2 = "//*[@class = 'a-list-item']";
	
	// product search xpath
	
	public static final String productsearchbox = "//*[@id=\"twotabsearchtextbox\"]";
	public static final String productlinks = "//*[@class = 'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";

	public static final String addtokart = "//*[@id=\"add-to-cart-button\"]";
	
	// forget
	public static final String help = "//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a/span";
	public static final String forgetlink = "//*[@id=\"auth-fpp-link-bottom\"]";
	
}
