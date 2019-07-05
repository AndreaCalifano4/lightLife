package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class NegozioFragment extends Fragment
{
    public NegozioFragment() {
    }
    ArrayList<ProdottoBean> prodotti = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Negozio");
        View rootView = inflater.inflate(R.layout.negozio, container, false);

        ProdottoBean p = new ProdottoBean(R.drawable.acai, "Bacche di Acai", "23.50", "L’Açaí è una bacca di colore blu-violacea che ha origine nelle foreste pluviali dell’Amazzonia.\\n\" +\n" +
                "                        \"Usata da sempre dai nativi brasiliani per le sue straordinarie capacità terapeutiche, è oggi considerata un superfood capace di donare straordinaria energia e resistenza.\\n\" +\n" +
                "                        \"Grazie ai suoi potenti effetti benefici non è più utilizzato solo come alimento base delle popolazioni brasiliane, ma sta conquistando anche l’Europa.\\n\" +\n" +
                "                          \"Il suo enorme contenuto di antiossidanti dovuto alla presenza dei suoi coloranti vegetali, gli antociani, ma anche la presenza di fibre, vitamine e minarali rende l’Açaí un alimento ottimo.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.maca, "Maca Peruviana", "3.50", "La Maca è un Superfood capace di contrastare la stanchezza fisica e mentale, dona energia e migliora il senso di benessere. Favorisce l’incremento della massa muscolare, rinforza il sistema immunitario. Sistema ormonale, fertilità dell’ uomo e della donna, afrodisiaco naturale, per questo viene chiamato il “Ginseng Peruviano”. Nelle donne aiuta a combattere i sintomi della menopausa.\\n\" +\n" +
                "                        \"\\n\" + \"Grazie alla sua composizione chimica la Maca rappresenta un alimento completo. I Carboidrati rappresentano circa il 60% del suo peso, è ricca di Fibre e Acidi grassi, proteine e amminoacidi essenziali per il nostro organismo. Ricca di vitamine del gruppo B, Vitamina C ed E, minerali come il Calcio, Fosforo,Potassio ed è ricca di Ferro.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.spiru, "Polvere di Spirulina", "15.61", "Le nostre Polvere di Spirulina Biologica, che contengono Spirulina Biologica in Polvere pura al 100%, sono uno dei superalimenti più potenti del pianeta e ti forniscono molti dei nutrienti di cui hai bisogno per mantenere uno stile di vita sano. Le nostre Polvere di Spirulina Biologica sono facili da aggiungere a qualunque dieta e forniscono bontà salutare al corpo e alla mente in modo semplice e conveniente.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.lucuma, "Lucuma in Polvere", "17.99", "DOLCEZZA SENZA COLPE: Il frutto della Lucuma ha un sapore naturalmente dolce e, aggiungendo questa polvere di qualità superiore ai tuoi frullati o cereali per la colazione, potrai dare una svolta deliziosamente dolce a qualunque elemento della tua dieta senza provare sensi di colpa.\\n\" +\n" +
                "                        \"NESSUNA AGGIUNTA SGRADEVOLE: 100% naturale e 100% biologica, la nostra Lucuma in Polvere di qualità superiore viene raccolta a mano sulle colline delle Ande peruviane. Non contiene nulla di innaturale, soltanto pura bontà in ogni confezione.\\n\" +\n" +
                "                        \"RICCA DI NUTRIENTI: la nostra Lucuma in Polvere unisce tre delle sostanze nutrienti più importanti per il tuo corpo sotto forma di Proteine, Calcio e Fosforo.\\n\" +\n" +
                "                        \"VARIETÀ SUPERIORE: non troverai la stessa qualità della nostra Lucuma in Polvere sugli scaffali dei supermercati. Il nostro prodotto in polvere è una varietà superiore con una concentrazione di nutrienti superiore rispetto al normale, e questo significa più bontà per te.\\n\" +\n" +
                "                        \"LA NOSTRA PROMESSA AL CLIENTE: puoi fidarti di noi e del nostro servizio clienti per ottenere delle risposte rapide alle tue domande. Offriamo una nostra speciale politica di rimborso senza rischi. Perciò acquista oggi in completa tranquillità.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.baobab, "Baobab biologico", "26.99", "ANO e NUTRITIVO: il Baobab in polvere è ricco di sostanze nutritive sane. Vitamina C, calcio, magnesio e potassio hanno dimostrato di avere benefici sulla salute e sono tutti riccamente presenti in questa polvere gustosa e nutriente.\\n\" +\n" +
                "                        \"100% BIOLOGICO: sai esattamente cosa stai inserendo nel tuo corpo con il Baobab in Polvere che ha ottenuto il Certificato Biologico della Soil Association. Raccolto in modo naturale e senza nulla di artificiale, è tutto ciò che vuoi e niente non desideri.\\n\" +\n" +
                "                        \"QUALITÀ SUPERIORE: il Baobab in Polvere si presenta in molte forme, ma su MySuperFoods vendiamo solo polvere di categoria superiore con il più elevato\\n\" +\n" +
                "                        \"ADATTO AD UNA DIETA VEGANA: i vegani amano il nostro Baobab in Polvere dal momento che è pieno di sostanze nutritive essenziali ed è interamente a base vegetale. Ricco di calcio e privo di prodotti di origine animale, è 100% vegano e vegetariano.\\n\" +\n" +
                "                        \"SERVIZIO CLIENTI CHE FUNZIONA: acquista in totale fiducia, sapendo che su MySuperFoods il nostro servizio clienti è sempre efficiente. Non sei soddisfatto del tuo acquisto? Faccelo sapere e te lo rimborseremo interamente.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.masc, "Maschera Viso Argilla", "11.95", "Maschera di fango del Mar Morto: il fango del Mar Morto è il top dei prodotti naturali per la cura della pelle, che ha effetti eccellenti di cura della pelle, utilizzando ingredienti di altissima qualità e funziona per tutti i tipi di pelle.\\n\" +\n" +
                "                        \"Deep Cleaning Face Mask: estrae le impurità che si trovano in profondità negli strati della pelle, rimuove lo sporco, aiuta a detergere efficacemente la pelle e fornisce una sensazione termale lenitiva e rinfresca la pelle.\\n\" +\n" +
                "                        \"Rimuovi punti neri e acne: gli ingredienti trattano e puliscono la pelle, rimuovono cuticole e punti neri, acnes e cellule morte della pelle, che è un trattamento naturale contro l'acne per rimuovere lo sporco dalla pelle.\\n\" +\n" +
                "                        \"Elimina la tossina e abbellisce la pelle: attira le tossine dalla pelle profonda e pulisce in profondità i pori. Dona umidità alla pelle secca o sensibile per migliorare la carnagione, assorbire l'olio e offrirti una pelle sana.\\n\" +\n" +
                "                        \"Stringere la pelle e rimuovere le rughe: il nostro trattamento di fango di alta qualità stimola la circolazione sanguigna e ripristina il microelemento cutaneo, promuove il metabolismo della pelle, minimizza i pori, riduce le rughe e le rughe.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.the, "Tè Verde Matcha", "19.98", "BENEFICI TEA MATCHA: "+"\n- La Teanina aumenta la concentrazione riducendo ansia e nervosismo. "+"\n-  Aiuta la perdita di peso ed è consigliato come supplemento nella dieta quotidiana. (3) La Catechina aiuta la protezione delle cellule e di altre molecole nel corpo dal danneggiamento dei radicali liberi. (4) Alto contenuto di Fibre, Clorofilla, aminoacidi, Vitamina A, K ed E. (5) La Teanina in combinazione con la caffeina aumenta le attività celebrali alfa e stimola la concentrazione.\\n\" +\n" +
                "                        \"PROPRIETA' DEL MATCHA: Ricco di Catechina, un antiossidante che previene l'invecchiamento delle cellule. Il Matcha ha un alto contenuto di Teanina un aminoacido in grado di stimolare il cervello riducendo stress ed ansia e in grado di aumentare la concentrazione. Studi dell'università del Colorado dimostrano che una tazza di tè Matcha contiene 20 volte gli antiossidanti presenti in una normale tazza di te verde.\\n\" +\n" +
                "                        \"GRADO CERIMONIALE DI PRIMO RACCOLTO: Il nostro tea Matcha rappresenta l’essenza del te verde. Usato tradizionalmente in Giappone si distingue rispetto agli altri tea verde per il suo colore verde accesso, per il sapore ed è di grado superiore rispetto al Matcha di grado culinario. Vengono usate solo foglie di primo raccolto. Le foglie vengono protette dai raggi solari per 20 giorni prima di essere raccolte, mantenendo intatti ed elevati i livelli di Teanina e clorofilla presenti nel tè.\\n\" +\n" +
                "                        \"MATCHA QUALITA’ PRIMO GRADO : Puro e Biologico al 100%. Senza l’utilizzo di pesticidi e innaturali fertilizzanti chimici che non sono di aiuto per il corpo e la salute. Senza Glutine e Vegano. Prodotto in Giappone e certificato Biologico da organismi di controllo autorizzati dal Ministero delle Politiche Agricole.\\n\" +\n" +
                "                        \"✔ DISPONIBILITÀ GARANTITA: La completa soddisfazione dei clienti è la nostra priorità. Siamo a disposizione per qualsiasi domanda o osservazione. Ti prego di contattarci in caso di problemi con l'acquisto o per darci la tua opinione. Il tuo parere è importante per noi e aiuterà a migliorare i nostri servizi.");
        prodotti.add(p);
        p = new ProdottoBean(R.drawable.semi, "Sementi Dotto - Arnica", "2.00", "Arnica (Arnica Montana) Semi in confezione con busta doppia termosaldata. Appartiene alla famiglia delle Asteracee. Cresce per lo più allo stato spontaneo nelle brughiere e sui prati aridi, ma la si può coltivare anche in ambiente domestico, sia in terra che in vaso ( raggiunge un' altezza di 60cm). I suoi fiori ricordano vagamente quelli delle margherite e sono molto decorativi per il giardino, oltre a riempire l'aria di un profumo delicato.");
        prodotti.add(p);

        GridView gridView = rootView.findViewById(R.id.lista_prod);
        gridView.setAdapter(new CustomAdapterProdotti(getActivity(), prodotti));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InfoProdottoFragment infP = new InfoProdottoFragment();
                Bundle arguments = new Bundle();
                arguments.putInt("foto", prodotti.get(position).getPhoto());
                arguments.putString("nome", prodotti.get(position).getNome());
                arguments.putString("prezzo", prodotti.get(position).getPrezzo());
                arguments.putString("descrizione", prodotti.get(position).getDescrizione());
                infP.setArguments(arguments);
                prodotti = new ArrayList<>();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, infP).addToBackStack("infoProdotto").commit();
            }
        });
        return rootView;
    }
}