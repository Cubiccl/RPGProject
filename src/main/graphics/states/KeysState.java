package main.graphics.states;

import main.RPGProject;

public class KeysState extends MenuState {

	public KeysState() {
		this.addButton(new MSButton("Up : UP") {
			
			@Override
			public void onClick() {
				System.out.println("up");
			}
		});
		
		this.addButton(new MSButton("Back") {
			
			@Override
			public void onClick() {
				RPGProject.getGame().setState(StateManager.MENU);
			}
		});
	}

}
