package frame;

/* 패널의 기본기능을 정의해둔 가상 클래스 */

import javax.swing.*;

import event.*;
import list.*;

public abstract class TypingPanel extends JPanel {			// 기본적으로 패널사용하므로 상속받는다
	
	PracticeManager pm= new PracticeManager();				// 이벤트 클래스
	mainFrame frame;
}
