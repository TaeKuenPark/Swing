package event;

import javax.swing.*;

/* 버튼 Onoff편의 메소드 */

public class ButtonOnOffManager {

	
	public void turnButton(JButton btn, boolean type) {		// 버튼 온오프 메소드
		btn.setVisible(type);
	}

	public void turnLabel(JLabel btn, boolean type) {		// 버튼 온오프 메소드
		btn.setVisible(type);
	}
	public void turnTextField(JTextField btn, boolean type) {		// 버튼 온오프 메소드
		btn.setVisible(type);
	}
	
	public void fixButton(JButton btn, boolean type) {		// 버튼 활성화이벤트
		btn.setEnabled(type);
	}
	public void fixLabel(JLabel btn, boolean type) {		// 버튼 활성화 이벤트
		btn.setEnabled(type);
	}
	public void fixTextField(JTextField btn, boolean type) {// 텍스트 필드 활성화 이벤트
		btn.setEnabled(type);
	}
}
