package br.com.samerson.carteiradeclientes2.carteiradeclientes2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.InflaterInputStream;

import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Entidades.Clientes;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> {

    private List<Clientes> dados;

    public ClienteAdapter(List<Clientes> dados) {
        this.dados = dados;
    }


    @NonNull
    @Override
    public ClienteAdapter.ViewHolderCliente onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Referência da classe layout inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //Referência da view
        View view = inflater.inflate(R.layout.linha_clientes, parent, false);

        //Objeto do viewHolderCliente
        ViewHolderCliente viewHolderCliente = new ViewHolderCliente(view);

        return viewHolderCliente;
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolderCliente holder, int position) {

        if ((dados != null) &&(dados.size() > 0)) {

            //instância da classe clientes
            Clientes cliente = dados.get(position);

            //seta os valores na view.
            holder.txtNome.setText(cliente.nome);
            holder.txtTelefone.setText(cliente.telefone);

        }

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder {

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderCliente(View itemView) {
            super(itemView);

            txtNome = (TextView) itemView.findViewById(R.id.txtNome);
            txtTelefone = (TextView) itemView.findViewById(R.id.txtTelefone);

        }
    }
}


