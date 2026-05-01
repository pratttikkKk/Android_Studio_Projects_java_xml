package com.example.doctorbookingapp;

import android.content.*;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctorbookingapp.models.Doctor;
import java.util.List;
import com.example.doctorbookingapp.BookingActivity;
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    List<Doctor> list;
    Context context;

    public DoctorAdapter(Context context, List<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.doctor_card, parent, false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {

        Doctor d = list.get(position);

        holder.name.setText(d.name);
        holder.spec.setText(d.specialty);
        holder.degree.setText(d.degree);
        holder.img.setImageResource(d.image);

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, BookingActivity.class);
            i.putExtra("doctor", d.name + " - " + d.specialty);
            context.startActivity(i);
        });
    }

    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, spec, degree;
        ImageView img;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            spec = v.findViewById(R.id.spec);
            degree = v.findViewById(R.id.degree);
            img = v.findViewById(R.id.img);
        }
    }
}