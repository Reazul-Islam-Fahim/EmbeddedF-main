package com.example.embeddedf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

        holder.Tname.setText(model.getName());
        holder.Ttitle.setText(model.getTitle());
        holder.Tmsg.setText(model.getEmail());
        Glide.with(holder.Profile_pic.getContext()).load(model.getpurl()).into(holder.Profile_pic);

            holder.Profile_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity=(AppCompatActivity)view.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment(model.getName(),model.getTitle(),model.getEmail(),model.getpurl())).addToBackStack(null).commit();

                }
            });


    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView Profile_pic;
        TextView Tname,Ttitle,Tmsg;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            Profile_pic=itemView.findViewById(R.id.profile_pic);
            Tname=itemView.findViewById(R.id.Tname);
            Ttitle=itemView.findViewById(R.id.Ttitle);
            Tmsg=itemView.findViewById(R.id.Tmsg);


        }
    }
}
