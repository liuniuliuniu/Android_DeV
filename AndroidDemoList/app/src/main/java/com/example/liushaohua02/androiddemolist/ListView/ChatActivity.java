package com.example.liushaohua02.androiddemolist.ListView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liushaohua02.androiddemolist.BaseActivity;
import com.example.liushaohua02.androiddemolist.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);


        // 建立ListVIew
        ListView listView = findViewById(R.id.appList_List_View);


        // 设置数据
        List<ChatMessage> list = new ArrayList();

        list.add(new ChatMessage(1,2,"xiaoming","123","h哈哈啊啊",true));

        list.add(new ChatMessage(1,2,"xiaojun","456","------",false));

        list.add(new ChatMessage(1,2,"xiaoming","123","h哈哈啊啊",true));

        list.add(new ChatMessage(1,2,"xiaojun","123","+++++",false));
        list.add(new ChatMessage(1,2,"xiaoming","123","h哈哈啊啊",true));

        list.add(new ChatMessage(1,2,"xiaojun","123","=====",false));

        // 构建适配器
        listView.setAdapter(new ChatListAdaptor(this,list));

    }


    public static class ChatListAdaptor extends BaseAdapter {

        // 上下文
        Context context;
        // 模型数据
        List<ChatMessage> lists;

        // 消息类型
        interface IMessage_TYPE {
            int COM_MESSAGE = 0;
            int TO_MESSAGE = 1;
        }

        public ChatListAdaptor(Context context, List<ChatMessage> lists) {
            this.context = context;
            this.lists = lists;
        }


        @Override
        public int getCount() {
            return lists.size();
        }


        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        // 根据不同的类型我们来获取不同的视图
        // 根据服务器下发的id 来映射到本地的类型Type
        @Override
        public int getItemViewType(int position) {

            return lists.get(position).mISComming ? IMessage_TYPE.COM_MESSAGE : IMessage_TYPE.TO_MESSAGE;
        }

        // 不同类型item的数量
        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final ChatMessage entity = lists.get(position);
            boolean isComMsg = entity.mISComming;

            ViewHolder viewHolder;
            if (convertView == null) {

                // item类型区分
                if (isComMsg) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.chatting_item_msg_text_left, null);
                } else {
                    convertView = LayoutInflater.from(context).inflate(R.layout.chatting_item_msg_text_right, null);
                }
                viewHolder = new ViewHolder();
                viewHolder.mSendTime = (TextView) convertView.findViewById(R.id.tv_send_time);
                viewHolder.mUserName = (TextView) convertView.findViewById(R.id.tv_username);
                viewHolder.mContent = (TextView) convertView.findViewById(R.id.tv_chat_content);
                viewHolder.mTime = (TextView) convertView.findViewById(R.id.tv_time);
                viewHolder.mUserAvatar = (ImageView) convertView.findViewById(R.id.iv_user_head);
                viewHolder.mIsComMessage = isComMsg;
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.mSendTime.setText(entity.getmDate());
            viewHolder.mContent.setText(entity.getmContent());
            viewHolder.mContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            viewHolder.mTime.setText("");
            viewHolder.mUserName.setText(entity.getmName());

            if (isComMsg) {
                viewHolder.mUserAvatar.setImageResource(R.mipmap.ic_launcher);
            } else {
                viewHolder.mUserAvatar.setImageResource(R.mipmap.ic_launcher);
//                ImageLoader.getInstance().displayImage(entity.getAvatarUrl(), viewHolder.mUserAvatar);
            }
            return convertView;
        }

        static class ViewHolder {
            public TextView mSendTime;
            public TextView mUserName;
            public TextView mContent;
            public TextView mTime;
            public ImageView mUserAvatar;
            public boolean mIsComMessage = true;
        }
    }
}
