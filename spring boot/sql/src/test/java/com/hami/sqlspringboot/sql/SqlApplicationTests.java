package com.hami.sqlspringboot.sql;

import com.hami.sqlspringboot.sql.dal.repository.UserRepository;
import com.hami.sqlspringboot.sql.service.mapper.UserServiceMapper;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceMapper userServiceMapper;
	@Test
	void contextLoads() {
	}


	@Test
	void countUserLockedAndUserUnlocked() {
/*		PodamFactory podam = new PodamFactoryImpl();

		List<UserPodamModel> userModels = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			userModels.clear();
			for (int j = 0; j < 3451; j++) {
				userModels.addAll(
						podam.manufacturePojo(ArrayList.class,UserPodamModel.class)
				);
			}

			userRepository.saveAll(
					userModels.stream().map(userServiceMapper::getEntityFromUserPodamModel).collect(Collectors.toList())
			);
			System.out.println("*******************************************"  + i);
		}*/
		UserCountModel model = userRepository.countLockedAndUnlockedUsers();
		System.out.println(model.getCountLocked());
		System.out.println(model.getCountUnlocked());

	}

}
