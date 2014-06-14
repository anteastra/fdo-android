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
	
	// Метод, загружающий объект ShapeDrawable для рисования
	public void setDrawable(ShapeDrawable shape) {
		drawable = shape;
		// Привязываем объект ShapeDrawable
		drawable.setBounds(START_X, START_Y,
		START_X + drawable.getIntrinsicWidth(),
		START_Y + drawable.getIntrinsicHeight() );
		this.getHeight();
		// Требуем перерисовки графики
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		drawable.draw(canvas);
	}
}