package com.mykoshar.shop.api.components;

public enum RecipientNotification {
	
	NOTIFICATION_COMMENT("comment", "Подписчики на добавление комментов к товару"),
	NOTIFICATION_INACCURACY("comment_inaccuracy", "Подписчики на получение комментов типа 'Уточнение описания'"), 
	NOTIFICATION_MAIL_UPDATING("mail_sending", "Подписчики на получение чернового варианта письма"), 
	NOTIFICATION_PROPOSAL_PRICE("user_proposal_price", "Подписчики на получение уточняющих вопросов от пользователя"),
	NOTIFICATION_REPORT_ABOUT_MAIL_SENDING("report_about_mail_sending", "Подписчики на получение отчетов рассылок"),
	NOTIFICATION_CART_ORDER("cart_order", "Менеджера получающие уведомления о заказе");

	private String typeNotification;
	private String headerOfNotification;
	
	RecipientNotification(String typeNotification, String headerOfNotification){
		this.typeNotification = typeNotification;
		this.headerOfNotification = headerOfNotification;
	}

	public String getTypeNotification() {
		return typeNotification;
	}

	public String getHeaderOfNotification() {
		return headerOfNotification;
	}
		
}
