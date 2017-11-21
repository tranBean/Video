package com.awesome.tranbean.searchui.fragment;

import java.util.List;
import java.util.Random;

import com.awesome.tranbean.searchui.R;
import com.awesome.tranbean.searchui.view.LoadingPage;
/*import com.itheima.googleplay.R;
import com.itheima.googleplay.protocol.TopProtocol;
import com.itheima.googleplay.tools.DrawableUtils;
import com.itheima.googleplay.tools.UiUtils;
import com.itheima.googleplay.view.Flowlayout;
import com.itheima.googleplay.view.LoadingPage.LoadResult;*/

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class TopFragment extends BaseFragment {

    private List<String> datas;

    /*@Override
    public View createSuccessView() {
        ScrollView scrollView = new ScrollView(UiUtils.getContext());
        scrollView.setBackgroundResource(R.drawable.grid_item_bg_normal);
        Flowlayout layout = new Flowlayout(UiUtils.getContext());
        int padding = UiUtils.dip2px(13);
        layout.setPadding(padding, padding, padding, padding);
        //layout.setOrientation(LinearLayout.VERTICAL);// �������Բ��ֵķ���
        int backColor = 0xffcecece;
        Drawable pressedDrawable = DrawableUtils.createShape(backColor);// ������ʾ��ͼƬ
        for (int i = 0; i < datas.size(); i++) {
            TextView textView = new TextView(UiUtils.getContext());
            final String str = datas.get(i);
            textView.setText(str);

            Random random = new Random();   //�������
            int red = random.nextInt(200) + 22;
            int green = random.nextInt(200) + 22;
            int blue = random.nextInt(200) + 22;
            int color = Color.rgb(red, green, blue);//��Χ 0-255
            GradientDrawable createShape = DrawableUtils.createShape(color); // Ĭ����ʾ��ͼƬ
            StateListDrawable createSelectorDrawable = DrawableUtils.createSelectorDrawable(pressedDrawable, createShape);// ����״̬ѡ����
            textView.setBackgroundDrawable(createSelectorDrawable);
            textView.setTextColor(Color.WHITE);
            //textView.setTextSize(UiUtils.dip2px(14));
            int textPaddingV = UiUtils.dip2px(4);
            int textPaddingH = UiUtils.dip2px(7);
            textView.setPadding(textPaddingH, textPaddingV, textPaddingH, textPaddingV); //����padding
            textView.setClickable(true);//����textView���Ա����
            textView.setOnClickListener(new OnClickListener() {  // ���õ���¼�

                @Override
                public void onClick(View v) {
                    Toast.makeText(UiUtils.getContext(), str, 0).show();
                }
            });
            layout.addView(textView, new LayoutParams(LayoutParams.WRAP_CONTENT, -2));// -2 ��������
        }

        scrollView.addView(layout);
        return scrollView;
    }

    @Override
    protected LoadResult load() {
        TopProtocol protocol = new TopProtocol();
        datas = protocol.load(0);
        return checkData(datas);
    }*/

    @Override
    public View createSuccessView() {
        /*BaseListView listView = new BaseListView(UiUtils.getContext());
        listView.setAdapter(new ListBaseAdapter(datas, listView) {

            @Override
            protected List<AppInfo> onload() {
                AppProtocol protocol = new AppProtocol();
                List<AppInfo> load = protocol.load(0);
                datas.addAll(load);
                return load;
            }

        });*/
        View view = View.inflate(getActivity(), R.layout.fragment_test, null);
        return view;
        //return listView;
    }

    /**
     * ��������� ��ȡ������������
     */
    protected LoadingPage.LoadResult load() {
        //AppProtocol protocol = new AppProtocol();
        //datas = protocol.load(0);
        //return checkData(datas); // ������� �����ֽ��  �ɹ�, ����,��
        return LoadingPage.LoadResult.success;
    }
}
