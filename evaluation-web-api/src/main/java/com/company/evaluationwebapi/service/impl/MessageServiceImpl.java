package com.company.evaluationwebapi.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.company.evaluationwebapi.service.MessageService;

@Component
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String id) {
		final Locale locale = LocaleContextHolder.getLocale();		
		return messageSource.getMessage(id, null, locale);
	}
}