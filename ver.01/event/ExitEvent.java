package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitEvent implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		// 종료 이벤트
	}

}
