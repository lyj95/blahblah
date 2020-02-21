package com.blah.common.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blah.vo.FilesVo;

@Service
public class FileValidate implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object uploadFile, Errors errors) {
		FilesVo file = (FilesVo)uploadFile;
		
		if(file.getFilesDir().getSize() == 0) {
							//<form:errors path="file"> => path에 field값 사용
			errors.rejectValue("file", "errorCode", "Please select a file");
			//file에 대한 errorCode를 리턴
		}
		
	}

}