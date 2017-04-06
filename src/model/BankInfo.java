package model;

public class BankInfo {
  private String cardType;
  private String cardNumber;
  private String securityCode;
  private String expireMonth;
  private double balance;

  public BankInfo() {
  }

  public String getCardType() {
    return cardType;
  }
  public void setCardType(String cardType) {
    this.cardType = cardType;
  }
  public String getCardNumber() {
    return cardNumber;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public String getSecurityCode() {
    return securityCode;
  }
  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }
  public String getExpireMonth() {
    return expireMonth;
  }
  public void setExpireMonth(String expireMonth) {
    this.expireMonth = expireMonth;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }

  public boolean validData () {
    boolean isValid = true;

    if (this.cardNumber == null || this.cardNumber.trim().equals("") || this.cardNumber.length() != 16 )
      isValid = false;

    if (this.securityCode == null || this.securityCode.trim().equals("")) {
      if (!(this.securityCode.trim().length() == 3 || this.securityCode.trim().length() == 4))
        isValid = false;
    }
    if (this.cardType == null || this.cardType.trim().equals("")) isValid = false;
    if (this.expireMonth == null || this.expireMonth.trim().equals("")) isValid = false;

    return isValid;

  }

  public boolean sufficientFunds (double totalOrder) {
    return true;
  }

}
