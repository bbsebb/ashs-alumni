package fr.hoenheimsports.app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "phone")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Phone {
    @Id
    private String phoneNumber;
    private boolean isBlackListed;
    @OneToMany(mappedBy = "phone", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private Set<SMSHistoryEntity> smsHistoryEntity;

    // --- Méthodes utilitaires pour relation bidirectionnelle ---
    public void addSmsHistory(SMSHistoryEntity sms) {
        if (sms == null) return;
        smsHistoryEntity.add(sms);
        if (sms.getPhone() != this) {
            sms.setPhone(this);
        }
    }

    public void removeSmsHistory(SMSHistoryEntity sms) {
        if (sms == null) return;
        smsHistoryEntity.remove(sms);
        if (sms.getPhone() == this) {
            sms.setPhone(null);
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Phone phone = (Phone) o;
        return getPhoneNumber() != null && Objects.equals(getPhoneNumber(), phone.getPhoneNumber());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }


}
