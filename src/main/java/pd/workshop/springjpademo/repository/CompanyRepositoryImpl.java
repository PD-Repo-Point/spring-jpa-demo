package pd.workshop.springjpademo.repository;

import pd.workshop.springjpademo.entity.Company;

import java.util.Optional;

public class CompanyRepositoryImpl implements CompanyRepository{

    @Override
    public Optional<Company> save(Company company) {
        return Optional.empty();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteCompany(Company company) {

    }
}
