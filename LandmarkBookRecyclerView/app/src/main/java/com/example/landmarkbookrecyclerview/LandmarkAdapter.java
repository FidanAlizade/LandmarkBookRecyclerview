package com.example.landmarkbookrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbookrecyclerview.databinding.RecyclerRowBinding;

import java.util.ArrayList;


//- THE FIRST!!!- Bir adapter sinifi yaratdiq en birinci, Adapter sinifinden kalitim aldi
public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{



//-THE SIXTH!!!- Landmark ArrayListimi tanimlayip constructorunu yaratdiq
ArrayList<Landmark> landmarkArrayList;
    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }


//- THE FIFTH!!!- LandmarkAdapterin methodlarini implement etdik, ve <> arasinda tutucu sinifi belirledik.
    @NonNull
    @Override
//Bu metod XML i kodlarima baglamaq icin
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate sisirmek demek, yani hangi xml-i baglayacaksan onu inflate ediyorsun, "sisiryorsun"
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }



    @Override
//Bu metod hansi parametrler deyerler olacagini yazdiqmaq ucun
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int position) {
    holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);
//burda itemlere ne olacagini deyek
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }



    @Override
//bu method XML sayini belirlemek icin
    public int getItemCount() {
//-THE EIGHTH!!!- boylece olusturulacak XML sayini bulmak icin landmarkArraylist imi dinamik olarak belirledim, yani kac tane varsa item o kadar XML olusturulsun
        return landmarkArrayList.size();
    }



//-THE SECOND!!!- Tutucu sinif yaratdiq: LandmarkHolder ve o ViewHolder sinifinden kalitim aldi.
    public class LandmarkHolder extends RecyclerView.ViewHolder{
//-THE NINETH!!!-Sonra yaratdigimiz xmli binding ile cagirdiq
        private RecyclerRowBinding binding;
//-THE THIRD!!!- LandmarkHolder sinifinin constructor metodunu cagirdiq
        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
