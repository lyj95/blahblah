package com.blah.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Override
	public String search(String text) throws IOException {
		
		String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=" + text + "+영어로";
		Document doc = Jsoup.connect(url).get();
		Elements element = doc.select(".dic_dsc");
		
		String res = element.select("dl>dd:nth-child(3)").text();
		
		return res;
	}
	
}
