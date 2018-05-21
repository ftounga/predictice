package com.tounga.predictice.mapper;

import com.tounga.predictice.dto.CreditCardDTO;
import com.tounga.predictice.entity.CreditCardEntity;

public class CreditCardMapper {

	public static CreditCardDTO buildCreditCardDTOFromEntity(CreditCardEntity entity) {

		CreditCardDTO dto = new CreditCardDTO();
		dto.setCardNumber(entity.getCardNumber());
		dto.setCreditCardId(entity.getCreditCardId());
		dto.setCvc(entity.getCvc());
		dto.setExp_month(entity.getExp_month());
		dto.setExp_year(entity.getExp_year());
		return dto;

	}
}
