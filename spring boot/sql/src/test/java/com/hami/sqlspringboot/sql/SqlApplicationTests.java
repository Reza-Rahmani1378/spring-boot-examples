package com.hami.sqlspringboot.sql;

import com.hami.sqlspringboot.sql.dal.repository.UserRepository;
import com.hami.sqlspringboot.sql.service.date_time_mapper.CalendarTool;
import com.hami.sqlspringboot.sql.service.mapper.UserServiceMapper;
import com.hami.sqlspringboot.sql.service.model.UserCountGroupModel;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
		LocalDateTime from = LocalDateTime.of(2022, 2, 13, 15, 56);
		LocalDateTime to = LocalDateTime.of(2024, 2, 13, 15, 56);

		List<UserCountGroupModel> model = userRepository.countLockedAndUnlockedUsers(from,to);
		System.out.println(userServiceMapper.getReportUserOutputModelFromModel(model));
	}

	@Test
	public void convertLocalDateTimeToPersianDateStr() {
		LocalDateTime localDateTime = LocalDateTime.now();

				CalendarTool ca = new CalendarTool();
				ca.setGregorianDate(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
				ca.getIranianDate();
		String[] persianDateDetails = ca.getIranianDate().split("/");
		int year = Integer.parseInt(persianDateDetails[0]);
		int month = Integer.parseInt(persianDateDetails[1]);
		int day = Integer.parseInt(persianDateDetails[2]);
		System.out.println("Year is :" + year + "\n" + "Month is : " + month + "\n" + "Day is :" +  day + "\n");

	}


}
