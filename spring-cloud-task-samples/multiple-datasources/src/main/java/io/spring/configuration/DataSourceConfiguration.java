/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Michael Minella
 */
@Configuration
@Profile("cloud")
public class DataSourceConfiguration extends AbstractCloudConfig {

	@Bean(name = "taskDataSource")
	public DataSource taskDataSource() {
		System.out.println("Creating taskDataSource");
		return connectionFactory().dataSource("myappdb");
	}


	/// @Primary will let Spring Data JPA autoconfig use the following bean definitions

	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		System.out.println("Creating scdf dataSource");
		return connectionFactory().dataSource("relational-5b87cd56-fa4a-4a0b-a392-8c1ea57b3698");
	}

}

///*
//@Configuration
//@Profile("!cloud")
//public class DataSourceConfiguration {
//
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder()
//			.setType(EmbeddedDatabaseType.HSQL)
//			.build();
//	}
//
//	@Bean
//	public DataSource secondDataSource() {
//		return new EmbeddedDatabaseBuilder()
//			.setType(EmbeddedDatabaseType.H2)
//			.build();
//	}
//}
//*/
