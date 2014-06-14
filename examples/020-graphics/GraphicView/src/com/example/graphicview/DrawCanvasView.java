package com.example.graphicview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

public class DrawCanvasView extends View {
	private static final int START_X = 10;
	private static final int START_Y = 10;
	private ShapeDrawable drawable;
	
	public DrawCanvasView(Context context) {
		super(context);
		setFocusable(true);
		drawable = new ShapeDrawable();
	}
	
	// �����, ����������� ������ ShapeDrawable ��� ���������
	public void setDrawable(ShapeDrawable shape) {
		drawable = shape;
		// ����������� ������ ShapeDrawable
		drawable.setBounds(START_X, START_Y,
		START_X + drawable.getIntrinsicWidth(),
		START_Y + drawable.getIntrinsicHeight() );
		this.getHeight();
		// ������� ����������� �������
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		drawable.draw(canvas);
	}
}