package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Service {

	private static Service service;

	private Service() {
	}

	public static Service getInstance() {
		if (service == null) {
			service = new Service();
		}
		return service;
	}

	public String getSummonerInfo(String userName) throws IOException {
		Document doc = Jsoup.connect("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + userName
				+ "?api_key=RGAPI-f0eab367-315f-4bdf-8d6e-be48b205e430").ignoreContentType(true).get();

		Elements elements = doc.select("body");

		return elements.text();
	}

	public String getMatchesInfo(String accountId) throws IOException {

		Document doc = Jsoup.connect("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/" 
								+ accountId
								+ "?api_key=RGAPI-f0eab367-315f-4bdf-8d6e-be48b205e430").ignoreContentType(true).get();
		Elements elements = doc.select("body");

		return elements.text();

	}
}
