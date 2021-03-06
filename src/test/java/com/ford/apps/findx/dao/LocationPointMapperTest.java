
package com.ford.apps.findx.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ford.apps.findx.data.dao.LocationPointMapper;
import com.ford.apps.findx.data.entity.LocationPoint;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationPointMapperTest {

	@Autowired
	private LocationPointMapper locationPointMapper = null;

	@Test
	public void test01_inserts() {
		LocationPoint lp1 = new LocationPoint(0, "中国石化(宣武门加油站)", "北京市西城区宣武门东大街16号", "北京市", "北京市", "西城区", 
			"d397d3cd896852465cd4fe88", "skymarlio82", new Date());
		LocationPoint lp2 = new LocationPoint(0, "中国石化加油站(崇文门站)", "东城区崇文门东大街甲22号", "北京市", "北京市", "东城区", 
			"637df60ac9ee957241afe69d", "skymarlio82", new Date());
		LocationPoint lp3 = new LocationPoint(0, "中国石化加油站(金融街站)", "北京市西城区太平桥大街113号", "北京市", "北京市", "西城区", 
			"a42e980d461f805043ab9a9f", "skymarlio82", new Date());
		LocationPoint lp4 = new LocationPoint(0, "中国石化(牛街加油站)", "北京市西城区右安门内大街2号", "北京市", "北京市", "西城区", 
			"3d989073a218b8d921022033", "skymarlio82", new Date());
		List<LocationPoint> lps = new ArrayList<>();
		lps.add(lp1);
		lps.add(lp2);
		lps.add(lp3);
		lps.add(lp4);
		locationPointMapper.insertBatch(lps);
		List<LocationPoint> res = locationPointMapper.findAll();
		assertTrue(4 == res.size());
	}

	@Test
	public void test02_findTops() {
		LocationPoint lp1 = new LocationPoint(0, "中国石化(宣武门加油站)", "北京市西城区宣武门东大街16号", "北京市", "北京市", "西城区", 
			"d397d3cd896852465cd4fe88", "skymarlio82", new Date());
		LocationPoint lp2 = new LocationPoint(0, "中国石化(宣武门加油站)", "北京市西城区宣武门东大街16号", "北京市", "北京市", "西城区", 
			"d397d3cd896852465cd4fe88", "skymarlio82", new Date());
		LocationPoint lp3 = new LocationPoint(0, "中国石化加油站(金融街站)", "北京市西城区太平桥大街113号", "北京市", "北京市", "西城区", 
			"a42e980d461f805043ab9a9f", "skymarlio82", new Date());
		LocationPoint lp4 = new LocationPoint(0, "中国石化(牛街加油站)", "北京市西城区右安门内大街2号", "北京市", "北京市", "西城区", 
			"3d989073a218b8d921022033", "skymarlio82", new Date());
		List<LocationPoint> lps = new ArrayList<>();
		lps.add(lp1);
		lps.add(lp2);
		lps.add(lp3);
		lps.add(lp4);
		locationPointMapper.insertBatch(lps);
		List<LocationPoint> res = locationPointMapper.findTops();
		assertTrue(1 == res.size());
		assertTrue("中国石化(宣武门加油站)".equals(res.get(0).getName()));
	}
}