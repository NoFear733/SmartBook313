package SmartBook;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {
	public static void main(String[] args) {


		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}


		// String ss="SDDD";

	//	ParseBook.Read(ss);


	}

}