package com.claire.androidchatbubble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_meLb1)
    TextView tvMeLb1;
    @BindView(R.id.tv_friendLabel)
    TextView tvFriendLabel;
    @BindView(R.id.list_msg)
    ListView listMsg;
    @BindView(R.id.edit_msg_type)
    EditText editMsgType;
    @BindView(R.id.btn_chat_send)
    Button btnChatSend;

    boolean myMessage = true;
    private List<ChatBubble> chatBubbles;
    private ArrayAdapter<ChatBubble> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        chatBubbles = new ArrayList<>();
        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.left_chat_bubble, chatBubbles);
        listMsg.setAdapter(adapter);

        //event for button SEND
        setBtnChatSendOnClick();
    }

    @OnClick(R.id.btn_chat_send)
    public void setBtnChatSendOnClick() {
        btnChatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editMsgType.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Please input some text....", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    ChatBubble chatBubble = new ChatBubble(editMsgType.getText().toString(), myMessage);
                    chatBubbles.add(chatBubble);
                    adapter.notifyDataSetChanged();

                    editMsgType.setText("");
                    if (myMessage){
                        myMessage = false;
                    } else {
                        myMessage = true;
                    }
                }
            }
        });
    }
}
