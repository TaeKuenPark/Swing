package list;


import java.util.ArrayList;

import event.*;

public class Literacy {

	private ArrayList<String> literacy= new ArrayList<String>();			// 긴줄의 문장을 받으므로, 배열보다 ArrayList를 이용해 받는다.
	private String fileName;												// txt파일의 내용을 받아 출력
	
	public Literacy(String fileName) {
		
		FileLoadManager f = new FileLoadManager(fileName);					// fileName을 이용해File불러오기 이벤트 메소드를 불러온다
		literacy = f.getLiteracy();											// 파일 불러오기 이벤트의 불러오기 메소드
		
		//for(int i =0; i<literacy.size(); i++) {							// 이문장으로 현재 파일이 잘 인식 되는가를 확인하는 문장
		//	System.out.println(literacy.get(i));
		//}	
	}
	public void setFileName(String File_) {									// FileName set메소드
		this.fileName =File_;
	}
	public ArrayList<String> getLiteray() {									// 받은 ArrayList를 보내는 메소드
		return literacy;
	}
}
