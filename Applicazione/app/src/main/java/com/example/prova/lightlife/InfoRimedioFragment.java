package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoRimedioFragment extends Fragment {
    public InfoRimedioFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.informazione, container, false);
        String [] arrayPrezzo = {"30,5 €", "21,99 €", "2,44 €", "3,15 €", "4,40 €", "50,00 €", "6,00 €"};
        String [] arrayNome = {"ACETOSA", "ALOE VERA", "ARNICA", "GELSOMINO", "ENOTERA", "UVA URSINA", "AGNOCASTO"};
        String [] arrayTesto = {
                "L'acetosa ha proprietà digestive, depurative, diuretiche e antinfiammatorie grazie alla presenza di ossalati e di antrachinoni. Discrete, invece, le proprietà emmenagoghe e stomachiche.\n" +
                        "\n" +
                        "Tra i principi attivi della acetosa, troviamo la vitamina C (80 mg/100 g che rappresenta la metà del fabbisogno giornaliero), ossalati di calcio e di potassio, acido ossalico, tartarico e tannico, antrachinoni, ma anche amido, mucillagini e oli. L’ossalato di calcio è la sostanza che le dà quel sapore acidulo.",
                "Dalle foglie della pianta si estrae con lavoro manuale un succo denso, concentrato, della consistenza di un gel, il cui fitocomplesso contiene numerosissimi principi attivi dalle proprietà immunostimolanti, antinfiammatorie, depurative, nutrienti, remineralizzanti. Le molteplici virtù sembrano essere il frutto di un'azione sinergica di questi composti, che la rendono a tutti gli effetti, \"pianta dell'immortalità\" e \"regina di tutti i rimedi\". \n" +
                        "\n" +
                        "L'aloe ripristina la funzionalità dell'intestino pigro, svolgendo un'azione riequilibrante del pH e della flora batterica, utile nei casi di stitichezza e diarrea.",
                "L’Arnica montana (volg. Arnica) è uno tra i più utilizzati rimedi naturali per il trattamento di comuni disturbi legati al sistema cutaneo e all’apparato osteoarticolare. Grazie alle proprietà antiflogistica, antireumatica ed antiechimatosa è largamente impiegata per uso topico, sotto forma di pomata, olio o unguento, in caso di edemi post-traumatici, contusioni e reumatismi.",
                "Il gelsomino viene utilizzato per molti scopi perché molte sono le sue proprietà. Risulta essere un blando sedativo, capace di aiutare il risposo e di calmare gli stati mentali agitati (antistress).\n" +
                        "\n" +
                        "Il gelsomino è efficace nel lenire la tosse e i problemi respiratori. Viene utilizzato per le sue proprietà a carattere analgesico e antispasmodico anche nei casi di sindrome premestruale o di dolori durante il mestruo.\n" +
                        "\n" +
                        "Possiede anche delle capacità antiossidanti per via dei flavonoidi contenuti al suo interno diventando così anche un rimedio naturale antinvecchiamento perché contrasta i radicali liberi responsabili del invecchiamento cellulare.",
                "L'enotera (Oenothera biennis) appartiene alla famiglia delle Onagraceae. Nota come pianta protettiva contro le malattie della pelle, è utile per i disturbi del sistema ormonale femminile.",
                "Le foglie di uva ursina sono impiegate in fitoterapia contro numerosi ceppi batterici comunemente responsabili di infezioni del tratto urogenitale, perché agisce sia sull'infiammazione, che sull'infezione. Infatti la pianta è in grado di determinare un'azione antimicrobica, antinfiammatoria e calmante lo stimolo continuo della minzione. ",
                "I frutti di agnocasto contengono una piccola quantità di olio essenziale, flavonoidi, casticina, vitexina, isovitexina, alcaloidi, viticina, glucosidi e principi amari. Questi componenti conferiscono alla pianta la capacità di agire sull’ipofisi ed esercitare un’azione antiestrogenica e antispasmodica, indicata per contrastare l’acne, e tutti quei sintomi connessi alla fase premestruale, associati a nervosismo, irritabilità, sbalzi d’umore, ansia, depressione; e nei disturbi neurovegetativi della menopausa."};
        String [] arrayMod = {
                "Della pianta di Acetosa si utilizzano foglie e fusti freschi e la radice. Consumata fresca, l’acetosa ha un sapore acidulo e si usa in aggiunta alle insalate fresche, agli spinaci e le verdure cotte in genere.\n" +
                        "\n" +
                        "Per uso interno, in erboristeria, si utilizza la pianta intera o le foglie giovani. Il decotto è utile come diuretico e rinfrescante, per il trattamento di gengiviti ed in generale contro le infiammazioni della bocca.\n" +
                        "\n" +
                        "I cataplasmi delle foglie fresche sono un ottimo rimedio per le irritazioni della pelle e le punture di insetti. Il pediluvio con il decotto di acetosa è utile per decongestionare e favorire la circolazione sanguigna dei piedi.\n" +
                        "\n" +
                        "La radice, estratta dal terreno in autunno e posta in infusione o decotta, svolge azione lassativa e diuretica. Un impacco di foglie fresche, sminuzzate e stese sulla pelle del viso, chiude i pori dilatati e fa scomparire i cosiddetti “punti neri”.  \n" +
                        "\n" +
                        "In fitoterapia si può trovare la tintura madre ricavata dalla pianta intera, utile per la sua azione lassativa, antianemica, depurativa e nel trattamento della dermatosi.",
                "USO INTERNO\n" +
                        "\n" +
                        "Tutte le operazioni per l'estrazione del succo devono essere eseguite per quanto possibile lontano da fonti luminose, per evitarne l'ossidazione di alcuni principi attivi e annullarne così alcune proprietà; e immediatamente dopo la raccolta delle foglie.\n" +
                        "\n" +
                        "Pulire le foglie con una spugna leggermente umida, togliere le spine dai bordi delle foglie, tagliarle e sbucciarle, per eliminare le fibre esterne ed estrarre la parte centrale (filetto interno) traslucida, e spremerla e assumerla.\n" +
                        "\n" +
                        "In questo modo si recuperano in maniera integrale tutte le molecole di interesse fitoterapico in essa contenute, in grado di esplicare le molteplici attività della pianta.\n" +
                        "\n" +
                        "2 cucchiai di succo aloe vera appena svegli e 2 prima di andare a dormire, puro o diluito in succo di frutta, lontano dai pasti. ",
                "È possibile utilizzare la droga sotto forma di tintura madre (fattore di diluizione 1:10) per il risciacquo del cavo orale, unguenti, olii e pomate.",
                "uno dei metodi classici di assumere il gelsomino per via interna è il tè di gelsomino dove i fiori essiccati sono miscelati alle foglie del tè. Inoltre il fiore essiccato di gelsomino viene utilizzato così o come aroma in alcune ricette di pasticceria tipo biscotti e marmellate. L’aroma di gelsomino è ricercato e considerato una prelibatezza; infatti, è presente nella storia come fragranza nei cibi che arrivavano alle tavole dei nobili e del ceto delle persone più ricche che ne facevano vanto l’uso come un vezzo solo a loro concesso. Le sue proprietà, anche in piccoli dosaggi ad uso interno, sono di calmante, analgesico e lievemente sedativo.",
                "USO INTERNO\n" +
                        "\n" +
                        "L'olio di enotera si trova sia sotto forma di olio vegetale, nella dose di 1-2 cucchiai al giorno, da assumere assoluto.\n" +
                        "\n" +
                        "In commercio si trova anche come integratore alimentare sotto forma di perle da assumere nella quantità di 10 -15 mg. per kg di peso corporeo, in base al disturbo da trattare.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "USO ESTERNO\n" +
                        "\n" +
                        "L'olio di enotera può essere usato direttamente sulla pelle possibilmente la sera per usufruire dell'azione antiossidante e protettiva sulla pelle secca o che presenta disturbi, o in presenza di rughe; può essere aggiunto alla propria crema, per potenziare l'effetto antiage; oppure può essere unito all'oleolito di calendula o iperico, o altro olio vegetale, per usufruire dell'azione antinfiammatoria su zone particolarmente estese. ",
                "USO INTERNO\n" +
                        "\n" +
                        "Le preparazioni più comunemente consigliate sono l'infuso, il decotto o il macerato freddo. L'assunzione di liquidi e l'attività diuretica che ne consegue espletano un'azione lavante sulle vie urinarie, potenziando l'attività antimicrobica dell'arbutina. \n" +
                        "\n" +
                        "INFUSO: 1 cucchiaio foglie di uva ursina, 1 tazza d’acqua \n" +
                        "\n" +
                        "Versare l'uva ursina nell’acqua bollente e spegnere il fuoco. Coprire e lasciare in infusione per 10 min. Filtrare l’infuso e berne 4 tazze al giorno lontano dai pasti.\n" +
                        "\n" +
                        "Tintura madre di uva ursina: 80 gocce in 1L e 1/2 d’acqua minerale, da bere nell’arco della giornata, lontano dai pasti.",
                "800- mg estratto secco in compresse o capsule lontano dai pasti\n" +
                        "\n" +
                        "Tintura madre 30-40 gc da assumere 2 volte al giorno lontano dai pasti."};

        TextView tvNomeRimedio = rootView.findViewById(R.id.textViewNome);
        ImageView ivImgRimedio = rootView.findViewById(R.id.imageViewim);
        TextView tvPrezzoRimedio = rootView.findViewById(R.id.prezzoProdotto);
        TextView tvDescrizioneRimedio = rootView.findViewById(R.id.textViewDescrizione);
        TextView tvModalita = rootView.findViewById(R.id.textViewMod);

        TextView noV1 = rootView.findViewById(R.id.textViewP);
        noV1.setVisibility(View.INVISIBLE);
        TextView noV2 = rootView.findViewById(R.id.prezzoProdotto);
        noV2.setVisibility(View.INVISIBLE);
        Button noV3 = rootView.findViewById(R.id.buttonAcquista);
        noV3.setVisibility(View.INVISIBLE);

        ivImgRimedio.getLayoutParams().width = 800;
        ivImgRimedio.getLayoutParams().height = 500;
        ivImgRimedio.setPadding(110, 0, 0, 0);

        Bundle arguments = getArguments();
        String pos = arguments.getString("position");
        int i = Integer.parseInt(pos);
        switch (i){
            case 0:
                tvNomeRimedio.setText(arrayNome[0]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.acetosa));
                tvPrezzoRimedio.setText(arrayPrezzo[0]);
                tvDescrizioneRimedio.setText(arrayTesto[0]);
                tvModalita.setText(arrayMod[0]);
                break;
            case 1:
                tvNomeRimedio.setText(arrayNome[1]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.aloe));
                tvPrezzoRimedio.setText(arrayPrezzo[1]);
                tvDescrizioneRimedio.setText(arrayTesto[1]);
                tvModalita.setText(arrayMod[1]);
                break;
            case 2:
                tvNomeRimedio.setText(arrayNome[2]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.arnica));
                tvPrezzoRimedio.setText(arrayPrezzo[2]);
                tvDescrizioneRimedio.setText(arrayTesto[2]);
                tvModalita.setText(arrayMod[2]);
                break;
            case 3:
                tvNomeRimedio.setText(arrayNome[3]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.gelso));
                tvPrezzoRimedio.setText(arrayPrezzo[3]);
                tvDescrizioneRimedio.setText(arrayTesto[3]);
                tvModalita.setText(arrayMod[3]);
                break;
            case 4:
                tvNomeRimedio.setText(arrayNome[4]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.enotera));
                tvPrezzoRimedio.setText(arrayPrezzo[4]);
                tvDescrizioneRimedio.setText(arrayTesto[4]);
                tvModalita.setText(arrayMod[4]);
                break;
            case 5:
                tvNomeRimedio.setText(arrayNome[5]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.uvaurs));
                tvPrezzoRimedio.setText(arrayPrezzo[5]);
                tvDescrizioneRimedio.setText(arrayTesto[5]);
                tvModalita.setText(arrayMod[5]);
                break;
            case 6:
                tvNomeRimedio.setText(arrayNome[6]);
                ivImgRimedio.setImageDrawable(getResources().getDrawable(R.drawable.agnocasto));
                tvPrezzoRimedio.setText(arrayPrezzo[6]);
                tvDescrizioneRimedio.setText(arrayTesto[6]);
                tvModalita.setText(arrayMod[6]);
                break;
        }
        return rootView;
    }
    private View rootView;

}
