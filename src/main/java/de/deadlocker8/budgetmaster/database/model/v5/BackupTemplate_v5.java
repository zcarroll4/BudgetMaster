package de.deadlocker8.budgetmaster.database.model.v5;

import de.deadlocker8.budgetmaster.tags.Tag;

import java.util.List;
import java.util.Objects;

public class BackupTemplate_v5
{
	private Integer ID;
	private String templateName;
	private Integer amount;
	private Boolean isExpenditure;
	private BackupAccount_v5 account;
	private BackupCategory_v5 category;
	private String name;
	private String description;
	private BackupImage_v5 icon;
	private List<Tag> tags;
	private BackupAccount_v5 transferAccount;

	public BackupTemplate_v5()
	{
	}

	public Integer getID()
	{
		return ID;
	}

	public void setID(Integer ID)
	{
		this.ID = ID;
	}

	public String getTemplateName()
	{
		return templateName;
	}

	public void setTemplateName(String templateName)
	{
		this.templateName = templateName;
	}

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	public Boolean getExpenditure()
	{
		return isExpenditure;
	}

	public void setExpenditure(Boolean expenditure)
	{
		isExpenditure = expenditure;
	}

	public BackupAccount_v5 getAccount()
	{
		return account;
	}

	public void setAccount(BackupAccount_v5 account)
	{
		this.account = account;
	}

	public BackupCategory_v5 getCategory()
	{
		return category;
	}

	public void setCategory(BackupCategory_v5 category)
	{
		this.category = category;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public BackupImage_v5 getIcon()
	{
		return icon;
	}

	public void setIcon(BackupImage_v5 icon)
	{
		this.icon = icon;
	}

	public List<Tag> getTags()
	{
		return tags;
	}

	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}

	public BackupAccount_v5 getTransferAccount()
	{
		return transferAccount;
	}

	public void setTransferAccount(BackupAccount_v5 transferAccount)
	{
		this.transferAccount = transferAccount;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		BackupTemplate_v5 that = (BackupTemplate_v5) o;
		return Objects.equals(ID, that.ID) && Objects.equals(templateName, that.templateName) && Objects.equals(amount, that.amount) && Objects.equals(isExpenditure, that.isExpenditure) && Objects.equals(account, that.account) && Objects.equals(category, that.category) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(icon, that.icon) && Objects.equals(tags, that.tags) && Objects.equals(transferAccount, that.transferAccount);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(ID, templateName, amount, isExpenditure, account, category, name, description, icon, tags, transferAccount);
	}

	@Override
	public String toString()
	{
		return "BackupTemplate_v5{" +
				"ID=" + ID +
				", templateName='" + templateName + '\'' +
				", amount=" + amount +
				", isExpenditure=" + isExpenditure +
				", account=" + account +
				", category=" + category +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", icon=" + icon +
				", tags=" + tags +
				", transferAccount=" + transferAccount +
				'}';
	}
}
