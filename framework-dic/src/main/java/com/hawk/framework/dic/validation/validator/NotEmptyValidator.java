package com.hawk.framework.dic.validation.validator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.hawk.framework.dic.design.data.Word;
import com.hawk.framework.dic.service.DictionaryService;
import com.hawk.framework.dic.validation.ValidateException;
import com.hawk.framework.dic.validation.annotation.NotEmpty;
import com.hawk.framework.utility.tools.StringTools;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object>{
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Override
	public void valid(NotEmpty annotation, Object value, String code) throws ValidateException {
		boolean isValid = isValid(annotation,value,code);
		if (!isValid){
			
			String name = annotation.name();
			
			if (StringTools.isNullOrEmpty(name)){
				if (StringTools.isNotNullOrEmpty(annotation.value())){
					code = annotation.value();
				}
				Word word = dictionaryService.queryWord(code);
				name = word.getName();
			}
			
			
			
			
			throw new ValidateException("-1",name +"不能为空");
		}
	}

	private boolean isValid(NotEmpty annotation, Object value ,String code) throws ValidateException {
		if (value == null)
			return false;
		
		
		
		if (value instanceof String){			String str = (String)value;
			return StringTools.isNotNullOrEmpty(str);
		}
		
		if (value instanceof Collection){
			Collection<?> c = (Collection<?>)value;
			if (c.size() == 0)
				return false;
			else
				return true;
		}
		
		if (value.getClass().isArray()){
			Object[] o = (Object[])value;
			if (o.length == 0)
				return false;
			else
				return true;
		}
		
		throw new ValidateException("-1","unsupport object type for empty checking");
	}

	

}

