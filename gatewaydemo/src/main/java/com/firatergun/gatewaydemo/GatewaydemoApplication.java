package com.firatergun.gatewaydemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.firatergun.gatewaydemo.Enum.Currency;
import com.firatergun.gatewaydemo.Enum.ErrorCode;
import com.firatergun.gatewaydemo.Enum.Operation;
import com.firatergun.gatewaydemo.Enum.PaymentMethod;
import com.firatergun.gatewaydemo.Enum.Status;
import com.firatergun.gatewaydemo.entity.Acquirer;
import com.firatergun.gatewaydemo.entity.CustomerInfo;
import com.firatergun.gatewaydemo.entity.Fx;
import com.firatergun.gatewaydemo.entity.Merchant;
import com.firatergun.gatewaydemo.entity.Transaction;
import com.firatergun.gatewaydemo.repository.AcquirerRepository;
import com.firatergun.gatewaydemo.repository.CustomerInfoRepository;
import com.firatergun.gatewaydemo.repository.FxRepository;
import com.firatergun.gatewaydemo.repository.MerchantRepository;
import com.firatergun.gatewaydemo.repository.TransactionRepository;

@SpringBootApplication
public class GatewaydemoApplication {

	private static Logger log = LoggerFactory.getLogger(GatewaydemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GatewaydemoApplication.class, args);
	}
	
	@Bean
	BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner init(MerchantRepository mRepo, TransactionRepository tRepo, 
			AcquirerRepository aRepo, FxRepository fRepo, CustomerInfoRepository cRepo) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		return args -> {
			//Create Merchants
			List<Merchant> m = new ArrayList<Merchant>();
			m.add(new Merchant("AVIVA"));
			m.add(new Merchant("AMAZON"));
			m.add(new Merchant("WAITROSE"));
			m.add(new Merchant("COSTA"));
			mRepo.saveAll(m);
			//Create CustomerInfo
			List<CustomerInfo> c = new ArrayList<CustomerInfo>();
			c.add(new CustomerInfo("545577889789", "firat@gmail.com", "firat", "ergun"));
			c.add(new CustomerInfo("78978979798", "yeni@hotmail.com", "Ali", "veli"));
			c.add(new CustomerInfo("5616543152", "john.doe@gmail.com", "john", "Doe"));
			cRepo.saveAll(c);
			//Create Acquirers
			List<Acquirer> a = new ArrayList<Acquirer>();
			a.add(new Acquirer("MERGEN BANK"));
			a.add(new Acquirer("LYODS BANK"));
			a.add(new Acquirer("METRO BANK"));
			a.add(new Acquirer("BARCLEYS BANK"));
			aRepo.saveAll(a);
			//Create Fx 
			List<Fx> f = new ArrayList<Fx>();
			f.add(new Fx(150, Currency.EUR));
			f.add(new Fx(25, Currency.GBP));
			f.add(new Fx(35, Currency.USD));
			f.add(new Fx(65, Currency.USD));
			f.add(new Fx(50, Currency.GBP));
			f.add(new Fx(50, Currency.EUR));
			f.add(new Fx(55, Currency.USD));
			fRepo.saveAll(f);
			//Create Transactions
			List<Transaction> t = new ArrayList<Transaction>();
			t.add(new Transaction(m.get(0), Status.APPROVED, format.parse("2017-01-28"), c.get(0), a.get(1), null, PaymentMethod.CREDITCARD, Operation.DIRECT, f.get(0), ""));
			t.add(new Transaction(m.get(0), Status.APPROVED, format.parse("2019-01-18"), c.get(0), a.get(3), null, PaymentMethod.GIROPAY, Operation.THREED, f.get(1), ""));
			t.add(new Transaction(m.get(1), Status.APPROVED, format.parse("2016-01-21"), c.get(2), a.get(2), null, PaymentMethod.CREDITCARD, Operation.DIRECT, f.get(2), ""));
			t.add(new Transaction(m.get(2), Status.DECLINED, format.parse("2018-06-01"), c.get(1), a.get(0), ErrorCode.INCORRECT_PIN, PaymentMethod.IDEAL, Operation.THREEDAUTH, f.get(3), ""));
			t.add(new Transaction(m.get(1), Status.APPROVED, format.parse("2019-08-15"), c.get(0), a.get(2), null, PaymentMethod.IDEAL, Operation.THREEDAUTH, f.get(4), ""));
			t.add(new Transaction(m.get(1), Status.DECLINED, format.parse("2014-10-18"), c.get(2), a.get(3), ErrorCode.CURRENCY_NOT_ALLOWED, PaymentMethod.CREDITCARD, Operation.REFUND, f.get(5), ""));
			t.add(new Transaction(m.get(0), Status.ERROR, format.parse("2010-04-17"), c.get(2), a.get(1), ErrorCode.DO_NOT_HONOR, PaymentMethod.CREDITCARD, Operation.THREEDAUTH, f.get(6), ""));
			
			tRepo.saveAll(t);
			
			t.forEach(System.out::println);
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("AVIVA", format.parse("2019-01-18"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("AKBANK", format.parse("2017-10-21"), Status.DECLINED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("ABANK", format.parse("2017-09-18"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("HEPSIBURADA")));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("AMAZON", format.parse("2016-01-18"), Status.ERROR)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("VIVALAND", format.parse("2016-01-05"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("VIRGIN", format.parse("2014-07-30"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("EE", format.parse("2015-09-18"), Status.ERROR)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("BETHREE")));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("SOMERSET", format.parse("2018-01-01"), Status.WAITING)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("EXETER", format.parse("2011-02-14"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("DEVONFF")));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("ISBANK", format.parse("2019-04-21"), Status.APPROVED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("WAITROSE", format.parse("2018-06-01"), Status.DECLINED)));
//			log.info("ADD MERCHANT ->" +  mRepo.save(new Merchant("COSTA", format.parse("2018-12-10"), Status.APPROVED)));
		};
	}
}
