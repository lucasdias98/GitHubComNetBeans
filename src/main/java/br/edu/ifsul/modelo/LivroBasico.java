package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Lucas
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livrobasico")
public class LivroBasico implements Serializable{
    
    @Id
    @NotBlank(message = "A ISBN deve ser informado.")
    @Length(max = 50, message = "A ISBN não pode ter mais que {max} caracteres. ")
    @Column(name = "isbn", length = 50, nullable = false)
    private String ISBN;
    
    @NotBlank(message = "O título deve ser informado.")
    @Length(max = 100, message = "O título não pode ter mais que {max} caracteres. ")
    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;
    
    @NotBlank(message = "A sinópse deve ser informada.")
    @Length(max = 200, message = "A sinópse não pode ter mais que {max} caracteres. ")
    @Column(name = "resumo", length = 200, nullable = false)
    private String resumo;
    
    @NotBlank(message = "O nome da editora deve ser informado.")
    @Length(max = 50, message = "O nome da editora não pode ter mais que {max} caracteres. ")
    @Column(name = "editora", length = 50, nullable = false)
    private String editora;
    
    @NotNull(message = "O data de publicação deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name="data_publicacao", nullable = false)// para guardar somente a hora, use: columDefinition="time")
    private Calendar dataPuclicacao;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autores",
            joinColumns = 
                    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false),
                    inverseJoinColumns = 
                            @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false))
    private Set<Autor> autores = new HashSet<>();
    
    public LivroBasico(){
        this.dataPuclicacao = Calendar.getInstance();
    }
    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPuclicacao() {
        return dataPuclicacao;
    }

    public void setDataPuclicacao(Calendar dataPuclicacao) {
        this.dataPuclicacao = dataPuclicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
    
    
}
