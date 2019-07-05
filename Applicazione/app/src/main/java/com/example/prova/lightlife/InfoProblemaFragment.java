package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoProblemaFragment extends Fragment {
    public InfoProblemaFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.informazione, container, false);
        String [] arrayNome = {"EMICRANIA", "AEREOFAGIA", "TACHICARDIA", "VESCICHE", "IPERTENSIONE", "FORFORA", "NAUSEA"};
        String [] arrayTesto = {
                "L’emicrania è un disturbo ricorrente la cui durata cade di norma in un intervallo compreso fra le 4 e le 72 ore (3 giorni); è più diffuso nel sesso femminile ed in genere si manifesta nell’età giovane-adulta.\n" +
                        "\n" +
                        "I sintomi dell’emicrania sono:\n" +
                        "\n" +
                        "dolore di norma pulsante su un unico lato, che peggiora con la normale attività fisica associata ai movimenti quotidiani,\n" +
                        "nausea,\n" +
                        "vomito,\n" +
                        "fastidio indotto da suoni o luce.",
                "Quando c'è aerofagia si tende ad ingoiare troppa aria. Si verifica il fenomeno dell'aerogastria.\n" +
                        "\n" +
                        "Molto comune è l'aerofagia in gravidanza. Il motivo principale è che si hanno livelli molto più alti di progesterone, un ormone che rilassa i tessuti della muscolatura liscia in tutto il corpo, compreso il tratto gastrointestinale. Questo rilassamento rallenta la digestione, e può portare ad un aumento di gas, eruttazione e flatulenza, soprattutto dopo un pasto abbondante.",
                "La tachicardia può comparire improvvisamente e il primo sintomo che si avverte è proprio un'accelerazione del battito cardiaco con la sensazione di non riuscirlo a controllare.\n" +
                "\n" +
                "Generalmente il problema dura per pochi minuti ma ci sono anche casi in cui la tachicardia si avverte per ore o giorni. Spesso, a questo sintomo principale se ne affiancano altri, come le vertigini, gli svenimenti, l'ipotensione e anche, in rari casi, crisi epilettiche. Questi fenomeni possono scomparire con la stessa velocità con la quale si presentano.",
                "Si viene a creare un rigonfiamento ripieno di liquido, simile a una “bolla” con del siero. La vescica può riempirsi di sangue nel caso in cui piccoli vasi vengano danneggiati. Se dovute a morsi di ragno o cimici dei letti compare prurito. \n" +
                        "\n" +
                        "Se c’è febbre, tremore, dalla crosta fuoriesce un liquido color miele potrebbe essere legato a un’infezione.",
                "I sintomi dell'ipertensione variano di molto a seconda del soggetto, ma ce ne sono di inequivocabili che si rilevano con misurazione di base. Una persona è ipertesa, o ha la pressione alta, quando:\n" +
                        "\n" +
                        "La pressione arteriosa minima (ipertensione diastolica) supera costantemente il valore di 90 mmHg;\n" +
                        "La pressione massima (ipertensione sistolica) supera costantemente il valore di 140 mmHg.",
                "Piccoli \"coriandoli\" bianchi sulle spalle e sulla testa si devono a uno squilibrio della desquamazione delle cellule del cuoio capelluto. La forfora si deve a numerosi fattori fra le quali la dermatite seborroica, motivi climatici (specie in caso di clima freddo e umido), eventi emotivamente stressanti, uso di cosmetici inadeguati.\n" +
                        "\n" +
                        "La forfora può essere grassa o secca ed è neccessario distinuguere tra forfora fisiologica, patologica e occasionale. \n" +
                        "\n" +
                        "La causa principale di questo disturbo è la proliferazione della Malassezia furfur sul cuoio capelluto, un fungo che si nutre del sebo provocando un ricambio cellulare più veloce: negli uomini la forfora è più frequente proprio perché il sesso maschile produce maggiori quantità di sebo, a causa dei più elevati livelli di testosterone. ",
                "La nausea è una condizione di malessere generalizzata che si manifesta sovente prima del vomito. Il suo insorgere può rivelare una malattia organica del tubo digerente (stenosidel piloro o dell’intestino) o del sistema nervoso centrale (ipertensione endocranica).\n" +
                        "\n" +
                        "Può anche manifestarsi in circostanze non patologiche: all’inizio della gravidanza, come conseguenza di variazioni ormonali, o durante un viaggio (in aereo, in nave ecc.) per effetto del movimento dei liquidi presenti nell’orecchio interno. Quando il malessere si protrae nel tempo senza che insorgano vomito o altri segni organici, potrebbe trattarsi di un sintomo di natura psicologica che esprime una sensazione di disgusto, di rigetto."};
        String [] arrayRimedi = {
                "Aumentate il consumo di cibi ricchi di selenio, zinco e rame come fegato, molluschi, avocado, uva essiccata, funghi, cereali integrali, tonno, salmone, acciughe, tuorlo d'uovo. Fate in modo che il pasto sia sempre arricchito da un contorno di verdure: broccoli, ortaggi a foglia verde, cavoli, sedano.\n" +
                        "\n" +
                        "Integrate l'alimentazione con cibi ad alto contenuto di vitamina B6, beta-carotene e vitamina E, come carne di pollo, tacchino, fagioli, banane, formaggi freschi. \n" +
                        "\n" +
                        "Lo zenzero è ottimo per arginare nausea o vertigine che possono accompagnare l'emicrania.",
                "In caso di aerofagia non episodica occorre rivedere la dieta e la salute e creare un rapporto funzionale della seconda sulla prima. Per prima cosa: si deve rivedere il rapporto con la masticazione. Poi si devono individuare i responsabili della formazione di gas, eccoli, i quattro \"nemici\":\n" +
                        "\n" +
                        "Il lattosio, com'è noto, è lo zucchero contenuto naturalmente in latte e derivati; spesso si trova anche in alimenti trasformati come cereali, condimenti, pane a altri prodotti da forno. \n" +
                        "Il raffinosio è contenuto principalmente nei fagioli, ma anche alcune verdure ne contengono modiche quantità, per esempio cavoli e asparagi. \n" +
                        "Il fruttosio è lo zucchero contenuto naturalmente in molti tipi di frutta e ortaggi, per esempio carciofi, cipolle e pere. Anche il frumento contiene fruttosio. Questo zucchero viene inoltre spesso utilizzato come dolcificante.\n" +
                        "Il sorbitolo si trova naturalmente in moltissimi tipi di frutta, tra cui mele e pesche ed è spesso usato come dolcificante. \n" +
                        "Introducete nella dieta riso, orzo e alimenti che non irritino la mucosa intestinale e che siano poco zuccherini.",
                "Una buona abitudine è bere un infuso caldo prima di andare al letto (ottime camomilla, melissa e fiori di limetta). Tra gli altri rimedi provate a inserire sotto il guanciale un cuscino imbottito di lavanda.\n" +
                        "\n" +
                        "Vengono comunemente usati estratti fluidi di biancospino (Crataegus oxycantha) nella dose di 15-20 gocce, 2 o 3 volte al giorno, lontano dai pasti. Nei soggetti inquieti o sottoposti a stress prolungati, si usa invece l'estratto fluido di passiflora in gocce (15 gocce, diluite in poca acqua, 3 volte al giorno, lontano dai pasti).",
                "Ci sono molte erbe che aiutano nella rigenerazione del nuovo strato di pelle. Un’ottimo rimedio naturale è una crema alla calendula.\n" +
                        "\n" +
                        "La consolida maggiore è ricca di allantoina, sostanza che stimola le cellule e aiuta la pelle a ricrescere. Potete ricorrere anche a una bustina inumidita di camomilla, con proprietà antisettiche e antinfiammatorie.\n" +
                        "\n" +
                        "Buono anche l’iperico (o erba di San Giovanni) che aiuta la guarigione e ne velocizza il processo. L’aloe vera è molto efficace contro le vesciche.",
                "Le piante che intervengono sulla pressione alta, oltre che regolarizzare il battito cardiaco in caso di aritmia, tachicardia e palpitazioni, agiscono sul flusso ematico, fluidificando il sangue e scongiurando il rischio di malattie cardiovascolari associate a questo disturbo, in quanto ipertensione e l’aterosclerosi favoriscono tendenze ischemiche coronariche o cerebrali. ",
                "È utile frizionare sul cuoio capelluto l'olio essenziale di Betulla. Miracoloso è anche il Tea tree oil, potete cercare uno shampoo a base di questo rimedio fitoterapico. Nei soggetti ansiosi si usa l'Escholtzia californica sotto forma di estratto fluido, che ha proprietà sedative sul sistema nervoso centrale. Anche il  decotto di capelvenere è un ottimo rimedio contro la forfora e la caduta dei capelli: fare bollire 100 grammi di foglie essiccate in 1 litro di acqua. Filtrare il tutto e fare raffreddare. Il decotto dovrà essere impiegato come sostituto dello shampoo, almeno una volta a settimana.",
                "In caso di nausea è molto efficace lo zenzero. Anche la menta piperita è usata come attenuante dei disturbi legati alla sensazione di nausea. Un infuso di camomilla può essere utile per attutire la sensazione di nausea."};

        TextView tvNomeProblema = rootView.findViewById(R.id.textViewNome);
        ImageView ivImgProblema = rootView.findViewById(R.id.imageViewim);
        TextView tvDescrizioneProblema = rootView.findViewById(R.id.textViewDescrizione);
        TextView tvRimedi = rootView.findViewById(R.id.textViewMod);

        TextView noV1 = rootView.findViewById(R.id.textViewP);
        noV1.setVisibility(View.INVISIBLE);
        TextView noV2 = rootView.findViewById(R.id.prezzoProdotto);
        noV2.setVisibility(View.INVISIBLE);
        Button noV3 = rootView.findViewById(R.id.buttonAcquista);
        noV3.setVisibility(View.INVISIBLE);

        ivImgProblema.getLayoutParams().width = 800;
        ivImgProblema.getLayoutParams().height = 500;
        ivImgProblema.setPadding(110, 0, 0, 0);

        TextView changeT = rootView.findViewById(R.id.textViewM);
        changeT.setText("Rimedi Naturali:");

        Bundle arguments = getArguments();
        String pos = arguments.getString("position");
        int i = Integer.parseInt(pos);
        switch (i){
            case 0:
                tvNomeProblema.setText(arrayNome[0]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.emicrania));
                tvDescrizioneProblema.setText(arrayTesto[0]);
                tvRimedi.setText(arrayRimedi[0]);
                break;
            case 1:
                tvNomeProblema.setText(arrayNome[1]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.aereofagia));
                tvDescrizioneProblema.setText(arrayTesto[1]);
                tvRimedi.setText(arrayRimedi[1]);
                break;
            case 2:
                tvNomeProblema.setText(arrayNome[2]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.tachi));
                tvDescrizioneProblema.setText(arrayTesto[2]);
                tvRimedi.setText(arrayRimedi[2]);
                break;
            case 3:
                tvNomeProblema.setText(arrayNome[3]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.vesciche));
                tvDescrizioneProblema.setText(arrayTesto[3]);
                tvRimedi.setText(arrayRimedi[3]);
                break;
            case 4:
                tvNomeProblema.setText(arrayNome[4]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.iperte));
                tvDescrizioneProblema.setText(arrayTesto[4]);
                tvRimedi.setText(arrayRimedi[4]);
                break;
            case 5:
                tvNomeProblema.setText(arrayNome[5]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.forfo));
                tvDescrizioneProblema.setText(arrayTesto[5]);
                tvRimedi.setText(arrayRimedi[5]);
                break;
            case 6:
                tvNomeProblema.setText(arrayNome[6]);
                ivImgProblema.setImageDrawable(getResources().getDrawable(R.drawable.nausea));
                tvDescrizioneProblema.setText(arrayTesto[6]);
                tvRimedi.setText(arrayRimedi[6]);
                break;
        }
        return rootView;
    }
    private View rootView;
}
