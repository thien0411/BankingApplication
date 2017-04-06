package controller;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BankInfo;

/**
 * Servlet implementation class Bank
 */
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardType = request.getParameter("cardType");
		String cardNumber = request.getParameter("cardNumber");
		String securityCode = request.getParameter("securityCode");
		String expireMonth = request.getParameter("expireMonth");
		Double totalOrder = Double.parseDouble(request.getParameter("totalOrder"));
		
		int transactionStatus = 0;
		
		BankInfo aCreditCard = new BankInfo();
		
		aCreditCard.setCardNumber(cardNumber);
		aCreditCard.setCardType(cardType);
		aCreditCard.setSecurityCode(securityCode);
		aCreditCard.setExpireMonth(expireMonth);
		
		if(aCreditCard.validData() && aCreditCard.sufficientFunds(totalOrder)) {
			transactionStatus = 1;
		}

		PrintWriter out = response.getWriter(); 
		out.println(transactionStatus);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
