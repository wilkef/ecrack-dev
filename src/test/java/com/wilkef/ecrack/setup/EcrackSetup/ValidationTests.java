package com.wilkef.ecrack.setup.EcrackSetup;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.wilkef.ecrack.setup.controller.ValidationController;
import com.wilkef.ecrack.setup.dao.ValidationDao;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ValidationTests {

	
	
	@InjectMocks
    private ValidationController controller = new ValidationController();
	
	 @Mock
	   private ValidationDao dao;;
	
	
	
}
