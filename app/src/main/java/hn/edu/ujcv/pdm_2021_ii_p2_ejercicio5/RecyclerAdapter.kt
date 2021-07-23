import androidx.recyclerview.widget.RecyclerView
import  android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_ii_p2_ejercicio5.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Capitulo 1", "Capitulo 2", "Capitulo 3", "Capitulo 4", "Capitulo 5",
        "Capitulo 6", "Capitulo 7", "Capitulo 8")
    private val details = arrayOf("Item Detalle 1", "Item Detalle 2", "Item Detalle 3", "Item Detalle 4",
        "Item Detalle 5", "Item Detalle 6", "Item Detalle 7", "Item Detalle 8")

    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2,R.drawable.android_image_3,
        R.drawable.android_image_4,R.drawable.android_image_5,
        R.drawable.android_image_6,R.drawable.android_image_7,
        R.drawable.android_image_8)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v:View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v,"Click en el item $position",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = titles[position]
        viewHolder.itemDetail.text = details[position]
        viewHolder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


}