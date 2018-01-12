package SmartBook;

import org.telegram.telegrambots.api.methods.GetFile;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.api.objects.File;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


	@Override
	public String getBotUsername() {

		return "myracebot";
	}

	@Override
	public String getBotToken() {

		return "493918196:AAGtyZ43ap4L7hpnjDq4mDJWptSMPRx0-t8";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
		if (update.hasMessage()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId());

					Long x = update.getMessage().getChatId();
					message.setText(x.toString());

			SendDocument sendDocument = new SendDocument();
			sendDocument.setChatId(update.getMessage().getChatId());
			//sendDocument.setDocument(update.getMessage().getDocument().getFileId());
			GetFile getFilemeth = new GetFile();
			getFilemeth.setFileId(update.getMessage().getDocument().getFileId());


			//sendDocument.setNewDocument(new java.io.File("iii.fb2"));
			//GETFILE(PATH);

			//System.out.println(update.getMessage().getText());
			//Document doc = update.getMessage().getDocument();
			//System.out.println(doc.toString());



			try {
				execute(message);
				File file = execute(getFilemeth);

				//fi.getAbsolutePath("/fileSSS/");

				downloadFile(file);


				//System.out.print(fi.toString());
				//sendDocument(sendDocument);
				//execute(getFilexx);


			} catch (TelegramApiException e) {
				e.printStackTrace();

			}


			}
		}

	}




