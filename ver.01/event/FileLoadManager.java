package event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 파일 관리 매니저 */
public class FileLoadManager {

	private ArrayList<String> literacy= new ArrayList<String>();
	
	public FileLoadManager(String fileName) {									// 생성자
	
		File file = new File("C:\\Users\\User\\Desktop\\"+fileName);			// 파일 명을 받아 파일을 불러올 경로 설정
		//File file = new File("./"+fileName);									// 절대 경로 설정 안될때, 컴파일하는 디렉터리에서 사용시 사용
		loadTextFile(file, literacy);
	}
	
	
	public ArrayList<String> loadTextFile(File file, ArrayList<String> Arr_) {	// 불러올 파일의 문장은 길수 있으므로 ArrayList를 이용해 받는다.
		
			String str;															// 파일 받기를 위한 문당
			
		try {
			System.out.println("실행됨");											// 실행 테스트 문장
			
			FileInputStream fs =new FileInputStream(file);						// FileInputStream으로 현재 파일 경로에서 파일을 불러온다
			InputStreamReader ir =new InputStreamReader(fs,"euc-kr");			// InputStreamReader를 이용해 어느 인콛딩으로 불러올지 결정한다
			BufferedReader br = new BufferedReader(ir);							// BufferedReader를 이용해 불러온다
			
			//System.out.println(ir.getEncoding());
			while((str =br.readLine()) !=null) {								// 불러온 문장을 ArrayList에 끝까지 한줄씩 탐색하여
				
				Arr_.add(str);													// add메소드를 이용해 넣는다
			
			
			}
			//for(int i=0; i<literacy.size(); i++) {							// 이문장으로 경로의 파일이 잘 인식 되는지 확인
			//	System.out.println(Arr_.get(i));
			//}		
			
			ir.close();															// 파일 가져오기 작업이 종료되면, 파일을 닫는다.
			
		} catch(IOException e) {		// IO예외 처리(안해주면 IO기능이 안됨)
			e.printStackTrace();
			
		} catch(Exception e) {
			e.printStackTrace();
		
		}
		return Arr_;
	}
	
	public ArrayList<String> getLiteracy() {			// 메모장으로 입력받은 ArrayList를 불러온다.
		return literacy;
	}
	
}
