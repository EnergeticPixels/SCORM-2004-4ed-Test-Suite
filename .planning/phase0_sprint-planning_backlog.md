## Phase 0 Sprint Backlog (Concrete)

Source plan: [plan_modernization_firstblush.md](plan_modernization_firstblush.md)

### Sprint Context
- Sprint length: 4 weeks (20 working days)
- Goal: Lock modernization guardrails, acceptance criteria, and governance so Phase 1 execution can start with low ambiguity.
- Capacity model: 6 core contributors, 1 part-time advisor
- Sprint slicing convention for this file:
1. Sprint 0A = Weeks 1-2 of the 4-week sprint
1. Sprint 0B = Weeks 3-4 of the 4-week sprint
- Estimation units:
1. Story points (Fibonacci)
1. Engineering effort hours (team total)

### Owners
- Program Manager (PM): Chrisjen Avasarala
- Technical Lead (TL): Josephus Miller
- Java Lead (J-LD): Naomi Nagata
- Web Lead (W-LD): Alex Kamal
- QA Lead (QA): James Holden
- Accessibility Lead (A11Y): Camina Drummer
- Security Lead (SEC): Bobbie Draper
- DevOps/Build Engineer (DEVOPS): Amos Burton
- Product/Conformance SME (SME): Praxidike Meng

### Sprint Backlog
| ID | Backlog Item | Deliverable | Owner | Dependencies | SP | Est. Hours |
|---|---|---|---|---|---:|---:|
| P0-01 | Define modernization acceptance criteria | Approved criteria doc covering SCORM parity, Java 21 baseline, evergreen browser policy, WCAG 2.2 AA target | TL + SME | None | 5 | 14 |
| P0-02 | Define dual-mode scope boundaries | Decision record for legacy archival lane vs modern maintained lane, including in/out scope list | PM + TL | P0-01 | 3 | 8 |
| P0-03 | Build risk register v1 | Ranked risk register with likelihood/impact, mitigations, owners, review cadence | PM + SEC + QA | P0-01 | 5 | 12 |
| P0-04 | Define governance and ceremonies | Weekly triage template, conformance dashboard definition, escalation path | PM | P0-02, P0-03 | 3 | 8 |
| P0-05 | Publish architecture principles | Architecture constraints and standards: API-first, no applets, deterministic builds, accessibility by default | TL + J-LD + W-LD | P0-01, P0-02 | 5 | 12 |
| P0-06 | Define quality gates | PR checklist, definition of done, test gate policy, artifact evidence requirements | QA + TL | P0-01, P0-04 | 5 | 12 |
| P0-07 | Accessibility guardrail baseline | WCAG 2.2 AA checklist tailored to this project and testing protocol for manual/automated checks | A11Y + QA + W-LD | P0-01 | 3 | 10 |
| P0-08 | Security and supply chain baseline | Security baseline including SBOM requirement, vuln threshold, dependency policy, secret handling standard | SEC + DEVOPS | P0-01 | 5 | 12 |
| P0-09 | Build and runtime policy draft | Toolchain policy for Ant-first migration and Java 21 target lane, including version pinning strategy | DEVOPS + J-LD | P0-05 | 3 | 8 |
| P0-10 | Backlog decomposition for Phase 1 | Prioritized Phase 1 epics split into sprint-ready stories with acceptance criteria | PM + TL + QA | P0-01 through P0-09 | 8 | 18 |
| P0-11 | RACI and staffing confirmation | Named assignment matrix replacing placeholders for every role and item owner | PM | P0-02, P0-04 | 2 | 6 |
| P0-12 | Stakeholder sign-off package | Review packet and sign-off record with decisions and unresolved questions | PM + TL + SME | P0-01 through P0-11 | 3 | 8 |

### Totals
- Total story points: 50
- Total estimated hours: 128
- Recommended sprint load target: 42-46 SP (leave 10-15% buffer for discovery)

### Suggested Sprint Slicing
1. Sprint 0A (Weeks 1-2): P0-01, P0-02, P0-03, P0-05, P0-07, P0-08
1. Sprint 0B (Weeks 3-4): P0-04, P0-06, P0-09, P0-10, P0-11, P0-12

### Definition of Done for Phase 0
1. Acceptance criteria approved and versioned.
1. Dual-mode scope decision documented.
1. Risk register and governance cadence operational.
1. Quality, accessibility, and security guardrails published and adopted.
1. Phase 1 backlog decomposed, estimated, and owner-assigned.
1. Named owners finalized (no placeholders remain).

### Open Inputs Needed
1. Confirm this The Expanse role mapping is final for this project.
1. Confirm actual team capacity per role to refine hour estimates.
1. Confirm whether procurement/legal participates in sign-off for dependency policy.

### GitHub Projects Configuration (Recommended)

Use one GitHub Project and create one GitHub Issue per backlog row (P0-01 through P0-12).

### Suggested Project Fields
- Item ID (text)
- Owner Role (single select: PM, TL, J-LD, W-LD, QA, A11Y, SEC, DEVOPS, SME)
- Story Points (number)
- Estimate Hours (number)
- Remaining Hours (number)
- Blocked (single select: No, Yes)
- Dependency IDs (text)
- Acceptance Criteria (text)
- Evidence Link (text)
- Target Sprint (single select: Sprint 0A, Sprint 0B)

### Use Built-In Fields
- Assignees
- Labels
- Milestone
- Status

### Suggested Labels
- phase:0
- track:planning
- area:architecture
- area:qa
- area:security
- area:accessibility

### Suggested Views
1. Board by Status (To do, In progress, Done)
1. Table by Sprint (group by Target Sprint)
1. Risks/Blocked View (filter Blocked = Yes)
1. Phase 0 Burndown Input View (show Story Points, Remaining Hours, Status)

### Mapping Rules
1. Issue title format: [P0-XX] Backlog Item name
1. Issue body includes Deliverable, Dependencies, Acceptance Criteria, and Evidence section
1. Assign named owner in Assignees and keep Owner Role field for reporting
1. Use Dependency IDs field to reference upstream item IDs

### Minimal Automation
1. Auto-set Status to In progress when an issue is assigned.
1. Auto-set Status to Done when an issue is closed.
1. Optional: auto-set Blocked = Yes when label blocked is added.
