package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.databinding.ActivityMainBinding
import br.com.igorbag.githubsearch.databinding.RepositoryItemBinding
import br.com.igorbag.githubsearch.domain.Repository
import kotlinx.coroutines.flow.combine
import org.w3c.dom.Text

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        //  holder.preco.text = repositories[position].atributo

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}
        val repositoryItem = repositories[position]
        holder.itemView.setOnClickListener {
            carItemLister(repositoryItem)
        }
        holder.imageShare.setOnClickListener{
            btnShareLister(repositoryItem)
        }
        holder.textRepositoryName.text = repositoryItem.name
        holder.textStarsCount.text     = repositoryItem.starsCount.toString()
        holder.textLanguage.text       = repositoryItem.language
        holder.textCreationDate.text   = repositoryItem.creationDate.substring(0,10).split("-")[0]
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        //val atributo: TextView

        //init {
        //    view.apply {
        //        atributo = findViewById(R.id.item_view)
        //    }
        val imageShare : ImageView
        val textRepositoryName: TextView
        val textStarsCount:TextView
        val textLanguage: TextView
        val textCreationDate:TextView
        init {
            view.apply {
                imageShare         = findViewById(R.id.iv_share)
                textRepositoryName = findViewById(R.id.tv_repository_name)
                textStarsCount     = findViewById(R.id.tv_stars_count)
                textLanguage       = findViewById(R.id.tv_repository_language)
                textCreationDate   = findViewById(R.id.tv_repository_creation_date)
            }
        }
    }
}


