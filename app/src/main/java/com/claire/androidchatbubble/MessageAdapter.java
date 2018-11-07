package com.claire.androidchatbubble;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<ChatBubble>  {
    private Context context;
    private List<ChatBubble> message;

    public MessageAdapter(Context context, int resource, List<ChatBubble> objects) {
        super(context, resource, objects);
        this.context = context;
        this.message = objects;
    }

    /**
     * @param position 每次顯示時都會為每個位置調用getView().
     * @param convertView 由於getView()被多次調用，每次膨脹新視圖都很昴貴，因此列表
     * 視圖提供了之前創建的視圖之一以供「重用」。 如果先前的視圖為null，則使用inflater.inflate()來擴展佈局
     * 所以主要負責動態地在ListView中添加消息。
     *
     * @param parent 對父視圖的引用，該視圖將是該視圖的子視圖
     */
    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; //由視圖類型確定
        ChatBubble chatBubble = getItem(position);
        int viewType = getItemViewType(position);

        if (chatBubble.isMyMessage()) {
            layoutResource = R.layout.left_chat_bubble;
        } else {
            layoutResource = R.layout.right_chat_bubble;
        }

        if (convertView != null){
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //set message content
        holder.msg.setText(chatBubble.getContent());

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types.
        // this is value should never change at runtime.
        // Value 2 is returned because of left and right views.
        return 2;
    }

    private static class ViewHolder{
        private TextView msg;
        public ViewHolder(View v){
            msg = (TextView)v.findViewById(R.id.txt_msg);
        }
    }
}
