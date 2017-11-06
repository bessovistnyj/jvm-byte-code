package ru.napadovskiu.fileManager.menuFileManager;

import java.io.IOException;

public interface UserAction {

	String key();

	void execute(String string) throws IOException;
	
	String info();

}