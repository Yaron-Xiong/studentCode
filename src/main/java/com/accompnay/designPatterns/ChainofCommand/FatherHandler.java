package com.accompnay.designPatterns.ChainofCommand;

import java.util.Objects;

public class FatherHandler extends Handler {

	@Override
	public void hand(IWoman woman) {
		if (woman.getType() == FATHER) {
			System.out.println("父亲允许：" + woman.getWant());
			return;
		}
		if (!Objects.isNull(getNextHandler())) {
			//向下传递
			getNextHandler().hand(woman);
			return;
		}
		System.out.println("父亲不允许：" + woman.getWant());
	}
}
