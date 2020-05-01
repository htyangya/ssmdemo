package domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {

    private Integer id;
    private Integer userid;
    @NonNull
    public String name;
    @NonNull
    private  Float money;

    @Override
    public boolean equals(Object obj) {
        Account obj1=(Account) obj;

        return this.name == obj1.name;
    }
}
