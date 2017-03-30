package controller;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		if(aCreditCard.validData() && aCreditCard.sufficientFunds(totalOrder))
			transactionStatus = 1;

		PrintWriter out = response.getWriter(); 
		out.println(transactionStatus);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
