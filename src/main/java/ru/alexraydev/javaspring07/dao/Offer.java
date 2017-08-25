package ru.alexraydev.javaspring07.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import ru.alexraydev.javaspring07.validation.ValidEmail;

public class Offer {
	private int id;

	
	@Size(min=5, max=255)
	private String text;

    private User user;
	
	public Offer() {
		this.user = new User();
	}

	public Offer(User user, String text) {
		this.user = user;
        this.text = text;
	}
	
	

	public Offer(int id, String text) {
		this.id = id;
        this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    public String getUsername() {
        return user.getUsername();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;

        Offer offer = (Offer) o;

        if (!text.equals(offer.text)) return false;
        if (!user.equals(offer.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
