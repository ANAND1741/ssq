package ssq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableMongoRepositories(basePackageClasses = BillRepository.class)
public class ssq {

//	@Autowired
//	private SchemaColumnAnalyzer schemaColumnAnalyzer;

	public static void main(String[] args) {
		SpringApplication.run(ssq.class, args);
	}

//	@Bean
//	public Function<KStream<String, DataAnalysisMessage>, KStream<String, DbWriterMessage>> processColumnAnalyzeMsg() {
//
//		return input ->
//				input.flatMapValues(value -> schemaColumnAnalyzer.analyze(value))
//						.map((key, value) -> new KeyValue<>(value.buildKey(), value));
//
//	}

}
