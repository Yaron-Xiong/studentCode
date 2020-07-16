package com.accompnay.designPatterns.ChainofCommand;

import java.util.Objects;

public class HusBandHandler extends Handler {
	@Override
	public void hand(IWoman woman) {
		if (woman.getType() == HUSBAND) {
			System.out.println("丈夫允许：" + woman.getWant());
			return;
		}
		if (!Objects.isNull(getNextHandler())) {
			//向下传递
			getNextHandler().hand(woman);
			return;
		}
		System.out.println("丈夫不允许：" + woman.getWant());
	}
}
